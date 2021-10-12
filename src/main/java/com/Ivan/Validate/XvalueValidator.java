package com.Ivan.Validate;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class XvalueValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        double x;
        try {
            x = (Double) o;
        } catch (Exception e) {
            throw new ValidatorException(new FacesMessage("В поле X должно быть число!"));
        }
        if (x < -5 || x > 3) {
            throw new ValidatorException(new FacesMessage("Значение должно быть в диапозоне -5...3"));
        }
    }
}

let setX = function (value) {
    document.getElementById("Xparent").children[0].value = value;
}
let setY = function (value) {
    document.getElementById("Yparent").children[0].value = value;
}
let setR = function (value) {
    document.getElementById("Rparent").children[0].children[0].ariaValueNow = value;
}
let getX = function () {
    return document.getElementById("Xparent").children[0].value;
}
let getY = function () {
    return document.getElementById("Yparent").children[0].value;
}
let getR = function () {
    return document.getElementById("Rparent").children[0].children[0].ariaValueNow;
}


createXButtonsListener = function () {
    xCommandButtons = document.documentElement.getElementsByClassName("XcommandButton");
    for (let xCommandButton of xCommandButtons) {
        xCommandButton.addEventListener("mousedown", function (e) {
            setX(xCommandButton.value);
        })
    }
}

drawArea = function () {
    let swg = document.getElementById("svgArea");
    let results = document.getElementsByClassName("result");
    let j = 0;
    let r = getR();
    console.log(getR())
    for (let i = results.length / 4; i > 0; i--) {
        let x = results[j++].innerText;
        let y = results[j++].innerText;
        j++;
        let got = results[j++];
        circle = document.createElementNS("http://www.w3.org/2000/svg", 'circle');

        circle.setAttribute('cx', String(250 + (Math.round(x / r * 200 * 10) / 10)));
        circle.setAttribute('cy', String(250 - (Math.round(y / r * 200 * 10) / 10)));
        circle.setAttribute("r", "3")
        circle.setAttribute("fill", "rgb(234,234,234)")
        swg.appendChild(circle);
    }
}

addDotChecker = function () {
    let swg = document.getElementById("svgArea");
    swg.addEventListener("mousedown", function (e) {
        let x = e.offsetX - 249.5;
        let y = e.offsetY - 249.5;
        let r = getR();
        x = x / 200 * r;
        y = -y / 200 * r;
        x = Math.ceil(x * 1000) / 1000;
        y = Math.ceil(y * 1000) / 1000;
        setX(x);
        setY(y);
        let checkButton = document.getElementById("checkButtonParent").children[0];
        if (validate()) {
            checkButton.click();
        }
    })
}

addDotChecker();
drawArea();
createXButtonsListener();

setXErr = function (xErrStr) {
    document.getElementById("xErr").innerText = xErrStr;
}
setYErr = function (yErrStr) {
    document.getElementById("yErr").innerText = yErrStr;
}
setRErr = function (rErrStr) {
    document.getElementById("rErr").innerText = rErrStr;
}

clearLastErrs = function () {
    setXErr("");
    setYErr("");
    setRErr("");
}

validateX = function (x) {
    if (isNaN(x)) {
        setXErr("Должно быть выбрано число!")
        return false;
    } else if (!(x >= -5 && x <= 3)) {
        setXErr("Значение должно быть в диапозоне [-5...3]");
    } else if (x.length > 17) {
        setXErr("Если это выскочило - значит кто-то решил сломать нас (в поле не может быть больше 17 символов)");
    } else {
        return true;
    }
}

validateY = function (y) {
    if (isNaN(y)) {
        setXErr("Должно быть выбрано число!")
        return false;
    } else if (!(y >= -3 && y <= 3)) {
        setXErr("Значение должно быть в диапозоне [-3...3]");
    } else if (y.length > 17) {
        setXErr("В поле не может быть больше 17 символов");
    } else {
        return true;
    }
}

validateR = function (r) {
    if (isNaN(r)) {
        setXErr("Должно быть выбрано число!")
        return false;
    } else if (!(r > 0 && r <= 3)) {
        setXErr("Значение должно быть в диапозоне (0...3)");
    } else if (r.length > 17) {
        setXErr("В поле не может быть больше 17 символов");
    } else {
        return true;
    }
}

validate = function () {
    clearLastErrs();

    let res = true;

    if (validateX(getX()) && validateY(getY()) && validateR(getR())) {
        return true;
    } else {
        return false;
    }
}


let afterAjaxSuccess = function (data) {
    if (data.status == "success") {
        drawArea();
        createXButtonsListener();
        addDotChecker();
    }
}
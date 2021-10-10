swg = document.getElementById("svgArea");
swg.addEventListener("mousedown", function (e){

    // circle = document.createElementNS("http://www.w3.org/2000/svg", 'circle');
    // circle.setAttribute('cx', e.offsetX);
    // circle.setAttribute('cy', e.offsetY);
    // circle.setAttribute("r", "3")
    // circle.setAttribute("fill", "rgb(234,234,234)")
    // swg.appendChild(circle);

    console.log(e.offsetX, e.offsetY)
})



let afterAjaxSuccess = function (data){
    if(data.status == "success") {
        // swg = document.getElementById("svgArea");
        // swg.addEventListener("mousedown", function (e){
        //
        //     circle = document.createElementNS("http://www.w3.org/2000/svg", 'circle');
        //     circle.setAttribute('cx', e.offsetX);
        //     circle.setAttribute('cy', e.offsetY);
        //     circle.setAttribute("r", "3")
        //     circle.setAttribute("fill", "rgb(234,234,234)")
        //     swg.appendChild(circle);
        //
        //     console.log(e.offsetX, e.offsetY)
        // })

        drawArea();
    }
}

xCommandButtons = document.getElementsByClassName("XcommandButton");
for (let xCommandButton of xCommandButtons){
    console.log("true")
    xCommandButton.addEventListener( "mousedown" ,function (e){
        let xField = document.getElementById("xHiddenDiv").children[0];
        console.log(xField)
        xField.value = xCommandButton.value;
        // console.log(xCommandButton.value)
    })
}

drawArea = function (){
    let swg = document.getElementById("svgArea");
    let results = document.getElementsByClassName("result");
    let j = 0;
    let r = document.getElementById("Rparent").children[0].children[0].ariaValueNow;
    console.log(results.length/4)
    for (let i = results.length/4; i > 0; i--){
        let x = results[j++].innerText;
        let y = results[j++].innerText;
        j++;
        let got = results[j++];
        console.log(String(250+(x/r*200)) + " " + String(250-(y/r*200)))
        circle = document.createElementNS("http://www.w3.org/2000/svg", 'circle');

        circle.setAttribute('cx', String(250+(x/r*200)));
        circle.setAttribute('cy', String(250-(y/r*200)));
        circle.setAttribute("r", "3")
        circle.setAttribute("fill", "rgb(234,234,234)")
        swg.appendChild(circle);
    }
    // swg.addEventListener("mousedown", function (e){
    //
    //     circle = document.createElementNS("http://www.w3.org/2000/svg", 'circle');
    //     circle.setAttribute('cx', e.offsetX);
    //     circle.setAttribute('cy', e.offsetY);
    //     circle.setAttribute("r", "3")
    //     circle.setAttribute("fill", "rgb(234,234,234)")
    //     swg.appendChild(circle);
    //
    //     console.log(e.offsetX, e.offsetY)
    // })
}
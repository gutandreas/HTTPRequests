function enableBody(enable){
    if (enable){
        document.getElementById("requestbody").disabled = false
    }
    else {
        document.getElementById("requestbody").disabled = true
    }
}

function sendRequest(){

    if (document.getElementById("radioget").checked){
        sendGetRequest()
    }
    else {
        sendPostRequest()
    }



}

function sendGetRequest(){
    fetch("/get", {
        method: 'GET'
    })
        .then(res => res.text())
        .then(responseData => {
            console.log(responseData)
            document.getElementById("answer").value = responseData
        })
}

function sendPostRequest(){
    let bodyText = document.getElementById("requestbody").value
    if (bodyText.length == 0){
        bodyText = "Kein Inhalt"
    }
    console.log(bodyText)
    fetch("/post", {
        method: 'POST',
        body: bodyText,
        headers: {
            "Content-type": "application/json"
        }
    })
        .then(res => res.text())
        .then(responseData => {
            console.log(responseData)
            document.getElementById("answer").value = responseData
        })
}

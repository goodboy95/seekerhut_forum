var socket = null;

//发送方法
function SocketSend()
{
    doSend(document.getElementById("sendtxt").value); 
}


//初始化连接
function SocketConnect(close, accept, error) {
    var host = window.location.host;
    var uri = "ws://" + host;
    //创建websocket,并定义事件回调
    socket = new WebSocket(uri);
    //socket.onopen = function (e) {};
    socket.onclose = function (e) { close(); };
    socket.onmessage = function (e) { accept(e.data); };
    socket.onerror = function (e) { error(e.data); };
}  
//发送信息
function doSend(message) {
    socket.send(message);
}

//关闭连接回调
function close() {
    if (reconnects < 5) {
        SocketConnect(close, SocketReceive, error);
        console.log("oh,my...It's closed, reconnecting...");
        reconnects++;
    }
}

//错误回调
function error(result) {
    if (reconnects < 5) {
        SocketConnect(close, SocketReceive, error);
        console.log("oh,my...It's error, reconnecting...");
        reconnects++;
    }
}




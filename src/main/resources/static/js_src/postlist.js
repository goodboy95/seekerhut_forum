var $ = require('jquery');

window.onload = function(){
    var queryStr = window.location.href.split('?')[1];
    var forumId = queryStr.split('=')[1];
    $.get('/api/forum/postlist/', {forumId: forumId, pageNo: 1, pageSize: 20}, function(resp){
        if (resp.code === 0){
            var postList = resp.data.postList;
            for (var i = 0; i < postList.length; i++){
                document.getElementById('postList').innerHTML += `<a href='/forum/postcontent?id=${postList[i].id}'>${postList[i].title}</a><br />`;
            }
        }
        else{
            alert(resp.msg);
        }
    });
    document.getElementById('submit').onclick = function(){
        var title = document.getElementById('title').value;
        var content = document.getElementById('content').value;
        $.post('/api/forum/sendpost/', {
            __RequestVerificationToken: $('#writePost').find('#token').find('input').val(),
            forumId: forumId, 
            title: title, 
            content: content}, function(resp){
            if (resp.code === 0){
                alert('帖子发表成功！');
                location.reload();
            }
            else{
                alert(resp.msg);
            }
        });
    };
}
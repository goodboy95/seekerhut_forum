var $ = require('jquery');

window.onload = function(){
    $.get('/api/forum/forumList/', {}, function(resp){
        if (resp.code === 0){
            var forumList = resp.data.forumList;
            var forumListHTML;
            for (var i = 0; i < forumList.length; i++){
                var forumId = forumList[i].id;
                var forumName = forumList[i].name;
                forumListHTML += `<a href=/forum/postlist?forumid=${forumId}>${forumName}</a>`;
            }
            document.getElementById('forumList').innerHTML = forumListHTML;
        }
    });
};
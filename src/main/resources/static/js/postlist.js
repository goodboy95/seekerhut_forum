/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, {
/******/ 				configurable: false,
/******/ 				enumerable: true,
/******/ 				get: getter
/******/ 			});
/******/ 		}
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = 83);
/******/ })
/************************************************************************/
/******/ ({

/***/ 1:
/***/ (function(module, exports) {

module.exports = jQuery;

/***/ }),

/***/ 83:
/***/ (function(module, exports, __webpack_require__) {

"use strict";


var $ = __webpack_require__(1);

window.onload = function () {
    var queryStr = window.location.href.split('?')[1];
    var forumId = queryStr.split('=')[1];
    $.get('/api/forum/postlist/', { forumId: forumId, pageNo: 1, pageSize: 20 }, function (resp) {
        if (resp.code === 0) {
            var postList = resp.data.postList;
            for (var i = 0; i < postList.length; i++) {
                document.getElementById('postList').innerHTML += '<a href=\'/forum/postcontent?id=' + postList[i].id + '\'>' + postList[i].title + '</a><br />';
            }
        } else {
            alert(resp.msg);
        }
    });
    document.getElementById('submit').onclick = function () {
        var title = document.getElementById('title').value;
        var content = document.getElementById('content').value;
        $.post('/api/forum/sendpost/', {
            __RequestVerificationToken: $('#writePost').find('#token').find('input').val(),
            forumId: forumId,
            title: title,
            content: content }, function (resp) {
            if (resp.code === 0) {
                alert('帖子发表成功！');
                location.reload();
            } else {
                alert(resp.msg);
            }
        });
    };
};

/***/ })

/******/ });
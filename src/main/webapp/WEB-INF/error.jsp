<%@ page language="java" contentType="text/html;
 charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>エラーページ</title>
  </head>
  <body>
    <h1>エラーページ</h1>
    <p>            
<c:out value="${error_msg}" /></p>
    <a href="javascript:history.back();">トップページに戻る</a>
  </body>
</html>

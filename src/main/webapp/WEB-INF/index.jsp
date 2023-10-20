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
    <title>社員選択</title>
  </head>
  <body>
    <h1>社員IDから検索</h1>
    <p>※全社員検索は、<b>all</b>と入れてください。</p>
    <form action="Shain" method="post">
      <p>
        <label for="shain_id">社員ID：</label>
        <input type="text" name="shain_id" />
        <button type="submit">検索する</button>
      </p>
    </form>
  </body>
</html>

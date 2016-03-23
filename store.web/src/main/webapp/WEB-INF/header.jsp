<%-- <meta id="mainUrl" content="${requestScope['javax.servlet.forward.request_uri']}"> --%>
<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="csrf_token"/> --%>
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<meta name="main_url" content="${urlBase}"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery/jquery-2.1.4.min.js"> </script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/bootstrap/js/bootstrap.min.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/angular/angular.min.js" ></script>  
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/dtstore.js" ></script> 
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/resources/lib/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/dtstore.css" rel="stylesheet">



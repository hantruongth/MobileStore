<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="WEB-INF/common/header.jsp"></jsp:include>

<%--<div class="container">--%>
<%--  <div class="jumbotron jSearch">--%>
<%--    <div class="search">--%>
<%--      <form class="form-inline" action="/search" method="get">--%>
<%--        <div class="form-group just-label">--%>
<%--          <label class="sr-only" for="from-label">FromLabel</label>--%>
<%--          <input type="text" readonly class="form-control-plaintext" id="from-label" value="From">--%>
<%--        </div>--%>
<%--        <div class="form-group mx-sm-3">--%>
<%--          <label for="fromValue" class="sr-only">FromValue</label>--%>
<%--          <input type="number" class="form-control" name="fromValue" id="fromValue" placeholder="$" min="0" value="${fromValue}">--%>
<%--        </div>--%>
<%--        <div class="form-group just-label-to">--%>
<%--          <label class="sr-only" for="to-label">ToLabel</label>--%>
<%--          <input type="text" readonly class="form-control-plaintext" id="to-label" value="To">--%>
<%--        </div>--%>
<%--        <div class="form-group mx-sm-3">--%>
<%--          <label for="toValue" class="sr-only">ToValue</label>--%>
<%--          <input type="number" class="form-control" name="toValue" id="toValue" placeholder="$" min="0" value="${toValue}">--%>
<%--        </div>--%>
<%--        <button type="submit" class="btn btn-primary" id="search">Search</button>--%>
<%--      </form>--%>
<%--    </div>--%>
<%--  </div>--%>

  <div class="row">
    <c:forEach items="${flowers}" var="flower">
      <c:url value='shopping-cart' var="linkAddToCart">
        <c:param name="flowerId" value="${flower.id}"/>
      </c:url>
      <div class="col-lg-3 col-md-4 col-xs-6 item">
        <div class="card h-100">
          <a href="detail?id=${flower.id}"><img class="card-img-top" src="<c:url value="resources/images/${flower.imageName}" />" alt=${flower.shortDescription}></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="detail?id=${flower.id}"><span id="item_${flower.id}">${flower.flowerName}</span></a>
            </h4>
            <h5>$${flower.price}</h5>
            <p class="card-text">${flower.shortDescription}</p>
          </div>
          <div class="card-footer text-center">
            <a href="${linkAddToCart}" class="btn btn-primary btn-lg active addToCart" role="button" aria-pressed="true">Add to cart</a>
          </div>
        </div>
      </div>
    </c:forEach>

  </div>
</div>

<jsp:include page="WEB-INF/common/footer.jsp"></jsp:include>
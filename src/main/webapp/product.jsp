<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="WEB-INF/common/header.jsp"></jsp:include>

<div id="productTitle"><h1>New Products</h1></div>
<div class="rowitem">
    <c:forEach items="${newProducts}" var="product">
<%--      <c:url value='shopping-cart' var="linkAddToCart">--%>
<%--        <c:param name="productId" value="${product.productId}"/>--%>
<%--      </c:url>--%>
      <div class="col-lg-3 col-md-4 col-xs-6 item">
        <div class="card h-100">
          <a href="productdetails?id=${product.productId}"><img class="card-img-top" src="<c:url value="../../resources/images/${product.images[0].url}" />" alt=${product.briefInformation}></a>
          <div class="card-body">
            <h4 class="card-title">
              <a href="productdetails?id=${product.productId}"><span id="item_${product.productId}">${product.productName}</span></a>
            </h4>
            <h5>$${product.price}</h5>
            <p class="card-text">${product.briefInformation}</p>
          </div>
          <div class="card-footer text-center">
            <a href="shopping-cart?id=${product.productId}" class="btn btn-primary btn-lg active addToCart" role="button" aria-pressed="true">Add to cart</a>
          </div>
        </div>
      </div>
    </c:forEach>
</div>

<div id="productTitle"><h1>Best Seller Products</h1></div>
<div class="rowitem">
  <c:forEach items="${bestSeller}" var="product">
<%--    <c:url value='shopping-cart' var="linkAddToCart">--%>
<%--      <c:param name="productId" value="${product.productId}"/>--%>
<%--    </c:url>--%>
    <div class="col-lg-3 col-md-4 col-xs-6 item">
      <div class="card h-100">
        <a href="productdetails?id=${product.productId}"><img class="card-img-top" src="<c:url value="../../resources/images/${product.images[0].url}" />" alt=${product.briefInformation}></a>
        <div class="card-body">
          <h4 class="card-title">
            <a href="productdetails?id=${product.productId}"><span id="item_${product.productId}">${product.productName}</span></a>
          </h4>
          <h5>$${product.price}</h5>
          <p class="card-text">${product.briefInformation}</p>
        </div>
        <div class="card-footer text-center">
          <a href="shopping-cart?id=${product.productId}" class="btn btn-primary btn-lg active addToCart" role="button" aria-pressed="true">Add to cart</a>
        </div>
      </div>
    </div>
  </c:forEach>
</div>


<jsp:include page="WEB-INF/common/footer.jsp"></jsp:include>
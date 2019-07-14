<%--
  Created by IntelliJ IDEA.
  User: tuyentle
  Date: 2019-07-13
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="WEB-INF/common/header.jsp"></jsp:include>

<div class="container">
    <div class="row shopping-cart">
        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <th>Product Name</th>
                <th>Images</th>
                <th>Detail Information</th>
                <th>Price</th>
            </tr>
            </thead>
            <tbody id="tblproductdetails">
            <tr class="item">
                <td>${product.productName}</td>
                <td><img src="<c:url value="../../resources/images/${product.images[0].url}" />" class="product-image"></td>
                <td>${product.detailInformation}
                    <div class="card-footer text-center">
                        <a href="shopping-cart?id=${product.productId}" class="btn btn-primary btn-lg active addToCart" role="button" aria-pressed="true">Add to cart</a>
                    </div>
                </td>
                <td>${product.price}</td>
            </tr>

            </tbody>
        </table>

    </div>
</div>

<jsp:include page="WEB-INF/common/footer.jsp"></jsp:include>

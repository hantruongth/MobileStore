<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="WEB-INF/common/header.jsp"></jsp:include>
<c:if test="${error_profile != null}">
    <div class="alert alert-danger" role="alert">
        <c:out value="${error_profile}"/>
    </div>
</c:if>

<div class="container">
    <div id="productTitle"><h1>Profile</h1></div>
    <div class="row shopping-cart">
        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <th>Full name</th>
                <th>Email</th>
                <th>Address</th>
                <th>Phone</th>
            </tr>
            </thead>
            <tbody id="tblMyCart">
            <tr class="item">
                <td>${user.fullName}</td>
                <td>${user.email}</td>
                <td>${user.address}</td>
                <td>${user.phone}</td>
            </tr>

            </tbody>
        </table>
    </div>
</div>
<jsp:include page="WEB-INF/common/footer.jsp"></jsp:include>
<%--
  Created by IntelliJ IDEA.
  User: tuyentle
  Date: 2019-07-13
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="WEB-INF/common/header.jsp"></jsp:include>

<c:if test="${user_info == null}">
    <div class="alert alert-danger" role="alert">
        <c:out value="${err_msg_checkout}"/>
    </div>
</c:if>

<c:if test="${user_info != null}">
    <div class="container">
        <div class="row shopping-cart">
            <form class="payment-form">
                <div class="form-group row">
                    <label for="fullName" class="col-sm-2 col-form-label">Full Name</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="fullName" name="fullName" placeholder="Name" value="${user.fullName}" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="address" class="col-sm-2 col-form-label">Shipping Address</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="address" name="address" placeholder="Address" value="${user.address}" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="address" class="col-sm-2 col-form-label">Payment</label>
                    <div class="col-sm-10">
                        <div class="form-check">
                            <label class="form-check-label" for="payInStore">
                                <input class="form-check-input" type="radio" id="payInStore" name="payment" value="Pay In Store" checked>
                                Pay In Store
                            </label>
                        </div>
                        <div class="form-check">
                            <label class="form-check-label" for="card">
                                <input class="form-check-input" type="radio" name="payment" id="card" value="Card">
                                Pay By Card
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="comment" class="col-sm-2 col-form-label">Comment</label>
                    <div class="col-sm-10">
                        <textarea cols="100" rows="10" class="form-control" id="comment" name="comment" placeholder="Comment"></textarea>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="offset-sm-2 col-sm-10">
                        <button type="submit" class="btn btn-outline-primary">
                            <span class="fa fa-calendar"></span> Confirm
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</c:if>

<jsp:include page="WEB-INF/common/footer.jsp"></jsp:include>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%-- <%@include file="/WEB-INF/jspf/header.jspf"%> --%>
<div id="container">
    <div id="prod_wrapper">
        <div id="panes">
            <c:forEach var="product" items="${newProducts}">
                <div>
                    <img src="${initParam.imgProductPath}${produt.getImage()}" alt="">
                    <h5>${product.getName()}</h5>
                    <p>${product.getDescription()}</p>
                    <p style="text-align: center;margin-right: 16px;">
                        <a href="#" class="button">More Info</a>
                        <a href="#" class="button">Buy Now</a>
                    </p>
                </div>
            </c:forEach>
        </div>
        <br clear="all">
        <div id="prod_nav">
            <ul>
                <c:set var="countProduct" scope="request" value="${1}" />
                <c:forEach var="product" items="${newProducts}">
                    <li>
                        <a href="#${countProduct}">
                            <img src="${initParam.imgProductPath}${product.getThumbImage()}" alt="">
                            <strong>${product.getName()}</strong>${product.getPrice()}
                        </a>
                    </li>
                    <c:set var="countProduct" scope="request" value="${countProduct+1}" />
                </c:forEach>
            </ul>
        </div>
        <!--close navigator-->
    </div>
    <div style="clear: both;">
    </div>
    <div class="one-fourth">
        <div class="heading_bg">
            <h2>Mac</h2>
        </div>
        <img src="img/demo/4.jpg" width="217" alt="">
    </div>
    <div class="one-fourth">
        <div class="heading_bg">
            <h2>ipad</h2>
        </div>
        <img src="img/demo/6.jpg" width="217" alt="">
    </div>
    <div class="one-fourth">
        <div class="heading_bg">
            <h2>iPhone</h2>
        </div>
        <img src="img/demo/3.jpg" width="217" alt="">
    </div>
    <div class="one-fourth">
        <div class="heading_bg">
            <h2>Accessories</h2>
        </div>
        <img src="img/demo/1.jpg" width="217" alt="">
    </div>
    <div style="clear: both; height: 40px;"></div>

</div>

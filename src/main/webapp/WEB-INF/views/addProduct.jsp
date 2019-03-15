<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Fonts -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css" integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous">
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <h1>Products</h1>
                <p>All the available products in our store</p>
                <a href="<c:url value="/j_spring_security_logout" />" class="btn btn-danger btn-mini pull-right">Logout</a>
                <div class="pull-right" style="padding-right:50px">
                    <a href="?language=en" >English</a>|<a href="?language=nl">Dutch</a>
                </div>
            </div>
        </section>
        <section class="container">
            <form:form modelAttribute="newProduct" class="form-horizontal" enctype="multipart/form-data">
                <form:errors path="*" cssClass="alert alert-danger" element="div" />
                <fieldset>
                    <legend>Add new Product</legend>

                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="productId">
                            <spring:message code="addProduct.form.productId.label"> </spring:message>
                        </label>
                        <div class="col-lg-10">
                            <form:input id="productId" path="productId" type="text" class="form:input-large"/>
                            <form:errors path="productId" cssClass="text-danger" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="name">Name</label>
                        <div class="col-lg-10">
                            <form:input id="name" path="name" type="text" class="form:input-large"/>
                            <form:errors path="name" cssClass="text-danger" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="unitPrice">Unit Price</label>
                        <div class="col-lg-10">
                            <form:input id="unitPrice" path="unitPrice" type="text" class="form:input-large"/>
                            <form:errors path="unitPrice" cssClass="text-danger" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="manufacturer">Manufacturer</label>
                        <div class="col-lg-10">
                            <form:input id="manufacturer" path="manufacturer" type="text" class="form:input-large"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="category">Category</label>
                        <div class="col-lg-10">
                            <form:input id="category" path="category" type="text" class="form:input-large"/>
                            <form:errors path="category" cssClass="text-danger" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="unitsInStock">Units In Stock</label>
                        <div class="col-lg-10">
                            <form:input id="unitsInStock" path="unitsInStock" type="text" class="form:input-large"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2" for="description">Description</label>
                        <div class="col-lg-10">
                            <form:textarea id="description" path="description" row="2"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2" for="condition">Condition</label>
                        <div class="col-lg-10">
                            <form:radiobutton path="condition" value="New"/>New
                            <form:radiobutton path="condition" value="Old"/>Old
                            <form:radiobutton path="condition" value="Refurbished"/>Refurbished
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2" for="productImage">
                        <spring:message code="addProduct.form.productImage.label" />
                        <div class="col-lg-10">
                            <form:input id="productImage" path="productImage" type="file" class="form:input-large" />
                            <form:errors path="productImage" cssClass="text-danger" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-lg-2" for="productPDF">
                        <spring:message code="addProduct.form.productPDF.label" />
                        <div class="col-lg-10">
                            <form:input id="productPDF" path="productPDF" type="file" class="form:input-large" />
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <input type="submit" id="btnAdd" class="btn btn-primary" value="Add"/>
                        </div>
                    </div>
                </fieldset>
            </form:form>
        </section>
    </body>
</html>

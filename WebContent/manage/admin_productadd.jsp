<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_user.jsp">用户管理</a><span class="crumb-step">&gt;</span><span>新增用户</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/MonkeyShop/manage/admind_doproductadd" method="post" id="myform" name="myform">
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>上级分类：</th>
                                <td>
                                   <select class="common-text required" name="parentId">
                                   <option value="0" selected="selected">根分类</option>
                                   <c:forEach var="f" items="${father}">
                                 
                                     <option value="${f.CATE_ID }">${f.CATE_NAME }</option>
                                    
                                   </c:forEach>
                                   </select>
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>子分类：</th>
                                <td>
                                   <select class="common-text required" name="childId">
                                  
                                   <c:forEach var="c" items="${child}">
                                 
                                     <option value="${c.CATE_ID }">${c.CATE_NAME }</option>
                                    
                                   </c:forEach>
                                   </select>
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>图书名称：</th>
                                <td>
                                    <input class="common-text required" id="title" name="cateName" size="50" value="" type="text">
                                </td>
                            </tr>
                              <tr>
                                <th><i class="require-red">*</i>图书描述：</th>
                                <td>
                                    <input class="common-text required" id="title" name="cateName" size="50" value="" type="text">
                                </td>
                            </tr>
                              <tr>
                                <th><i class="require-red">*</i>图书价格：</th>
                                <td>
                                    <input class="common-text required" id="title" name="cateName" size="50" value="" type="text">
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>库存数量：</th>
                                <td>
                                    <input class="common-text required" id="title" name="cateName" size="50" value="" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->

</body>
</html>
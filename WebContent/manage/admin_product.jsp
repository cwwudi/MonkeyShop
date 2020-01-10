<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">分类管理</span></div>
        </div>
       
        <div class="result-wrap">
            <form action="#" name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="/MonkeyShop/manage/admin_toproductadd"><i class="icon-font"></i>新增产品</a>
                       
                       <!--   <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>-->
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                          
                            
                            <th>ID</th>
                            <th>产品名称</th>
                            <th>产品描述</th>
                            <th>产品价格</th>
                            <th>库存数量</th>
                            <th>所属父类</th>
                            <th>所属分类</th>
                            <th>文件名称</th>                                   
                            <th>操作</th>
                          
                        </tr>
                        
                        <c:forEach var="p" items="${productlist}">
                       
                        <tr>
                        
                        	<td>${p.PRODUCT_ID}</td>
                        	<td>${p.PRODUCT_NAME}</td>
							<td>${p.PRODUCT_DESCRIPTION}</td>
							<td>${p.PRODUCT_PRICE}</td>
							<td>${p.PRODUCT_STOCK}</td>
							<c:forEach var="f" items="${flist}">
							<c:if test="${f.CATE_ID==p.PRODUCT_FCATE}">
							<td>${f.CATE_NAME}</td>
							</c:if>
							</c:forEach>
							<c:forEach var="c" items="${clist}">
							<c:if test="${c.CATE_ID==p.PRODUCT_CCATE}">
							<td>${c.CATE_NAME}</td>
							</c:if>
							</c:forEach>
							
							<td>${p.PRODUCT_FILENAME}</td>
                            <td>
                                <a class="link-update" href="admin_tocateupdate?id=${p.PRODUCT_ID }">修改</a>
                                &nbsp;&nbsp;&nbsp;<a class="link-del" href="javascript:Delete('确定要删除分类[${p.PRODUCT_ID}]?','admin_docatedelete?id=${c.CATE_ID }')">删除</a> 
                            </td>
                        </tr>
                        
                   
                      </c:forEach>
                      
                      <script>
                      	function Delete(mess,url){
                      		if(confirm(mess)){
                      			location.href=url;
                      		}
                      	}
                      	
                      
                      </script>
                    </table>
                
                </div>
            </form>
        </div>
    </div>
    <!--/main-->

</body>
</html>
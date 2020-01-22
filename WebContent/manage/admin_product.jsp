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
                    <table class="result-tab" width="60%">
                        <tr>
                          
                            
                            <th>ID</th>
                            <th>产品名称</th>
                                                             
                            <th>操作</th>
                          
                        </tr>
                        
                        <c:forEach var="p" items="${productlist}">
                       
                        <tr>
                        
                        	<td>${p.PRODUCT_ID}</td>
                        	<td><img alt="" src="/upload/${p.PRODUCT_FILENAME}"  height="100" width="80">${p.PRODUCT_NAME}</td>
						
                            <td>
                                <a class="link-update" href="admin_toproductmodify?id=${p.PRODUCT_ID }">修改</a>
                                &nbsp;&nbsp;&nbsp;<a class="link-del" href="javascript:Delete('确定要删除产品[${p.PRODUCT_NAME}]?','admin_doproductdelete?id=${p.PRODUCT_ID }')">删除</a> 
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
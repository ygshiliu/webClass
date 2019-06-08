<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="scott">
	
		<!-- 重新指定begin end -->
		<c:choose>
			<c:when test="${page.totalPage<=5 }">
				<c:set var="begin" value="1" ></c:set>
				<c:set var="end" value="${page.totalPage}"></c:set>
			</c:when>
			<c:when test="${page.pageNo<=3 }">
				<c:set var="begin" value="1" ></c:set>
				<c:set var="end" value="5"></c:set>
			</c:when>
			<c:otherwise>
				<c:set var="begin" value="${page.pageNo-2 }" ></c:set>
				<c:set var="end" value="${page.pageNo+2 }"></c:set>
				<c:if test="${end>=page.totalPage }">
					<c:set var="begin" value="${page.totalPage-4 }" ></c:set>
					<c:set var="end" value="${page.totalPage }"></c:set>
				</c:if>
			</c:otherwise>
		</c:choose>
	
		<c:forEach begin="${begin }" end="${end}" var="no">
			<c:choose>
				<c:when test="${page.pageNo==no }">
					<span class="current">${no }</span>
				</c:when>
				<c:otherwise>
					<a href="${page.path }&pageNo=${no }">${no }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
	共${page.totalPage }页，${page.totalCount }条记录 到第<input
		value="10" name="pn" id="pn_input" />页 <input
		id="sendBtn" type="button" value="确定">
	</div>
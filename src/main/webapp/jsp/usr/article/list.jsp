<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.ll.comu.article.dto.ArticleDto" %>

<%
    List<ArticleDto> articles = (List<ArticleDto>)request.getAttribute("articles");
%>

<%@ include file="../common/head.jsp"%>

<section>
    <div class="container px-3 mx-auto">
        <h1 class="font-bold text-lg">게시물 리스트</h1>

        <ul class="mt-5">
<%--            for문을 사용하면 el태그를 사용할 수 없음--%>
            <% for ( ArticleDto article : articles ) { %>
            <li class="flex">
                <a class="w-[40px] hover:underline hover:text-[red]" href="/usr/article/detail/<%=article.getId()%>"><%=article.getId()%></a>
                <!-- flex-grow : 성장성 1 -->
                <a class="flex-grow hover:underline hover:text-[red]" href="/usr/article/detail/<%=article.getId()%>"><%=article.getTitle()%></a>
                <a onclick="if ( !confirm('정말로 삭제하시겠습니까?') ) return false;" class="hover:underline hover:text-[red] mr-2" href="/usr/article/delete/<%=article.getId()%>">삭제</a>
                <a class="hover:underline hover:text-[red]" href="/usr/article/modify/<%=article.getId()%>">수정</a>
            </li>
            <% } %>
        </ul>
    </div>
</section>


<%@ include file="../common/foot.jsp"%>
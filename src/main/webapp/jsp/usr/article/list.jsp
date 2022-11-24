<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.ll.comu.article.dto.ArticleDto" %>

<%
    List<ArticleDto> articles = (List<ArticleDto>)request.getAttribute("articles");
%>

<h1>게시물 리스트</h1>

<script src="https://cdn.tailwindcss.com"></script>

<section>
    <div class="container px-3 mx-auto">
        <h1 class="font-bold text-lg">게시물 리스트</h1>

        <ul class="mt-5">
            <% for ( ArticleDto article : articles ) { %>
            <li class="flex">
                <a class="w-[40px] hover:underline hover:text-[red]" href="/usr/article/detail/<%=article.getId()%>"><%=article.getId()%></a>
                <!-- flex-grow : 성장성 1 -->
                <a class="flex-grow hover:underline hover:text-[red]" href="/usr/article/detail/<%=article.getId()%>"><%=article.getTitle()%></a>
                <a class="w-[100px] hover:underline hover:text-[red]" href="/usr/article/delete/<%=article.getId()%>">삭제</a>
            </li>
            <% } %>
        </ul>
    </div>
</section>
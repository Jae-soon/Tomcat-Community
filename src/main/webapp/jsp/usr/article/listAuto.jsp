<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../common/head.jsp"%>

<script>
    let Articles__lastId = 0;

    function Articles__loadMore() {
        fetch(`/usr/article/getArticles?fromId=\${Articles__lastId}`)
            .then(data => data.json())
            .then(responseData => {
                const articles = responseData.data;
                for ( const index in articles ) {
                    const article = articles[index];
                    const html = `
                        <li class="flex">
                        <a class="w-[40px] hover:underline hover:text-[red]" href="/usr/article/detail/\${article.id}">\${article.id}</a>
                        <a class="flex-grow hover:underline hover:text-[red]" href="/usr/article/detail/\${article.id}">\${article.title}</a>
                        <a onclick="if ( !confirm('정말로 삭제하시겠습니까?') ) return false;" class="hover:underline hover:text-[red] mr-2" href="/usr/article/delete/\${article.id}?_method=DELETE">삭제</a>
                        <a class="hover:underline hover:text-[red]" href="/usr/article/modify/\${article.id}">수정</a>
                    </li>
                `;
                    $('.articles').append(html);
                }

                if ( articles.length > 0 ) {
                    Articles__lastId = articles[articles.length - 1].id;
                }
            });
    }
</script>

<section>
    <div class="container px-3 mx-auto">
        <h1 class="font-bold text-lg">게시물 리스트(오토)</h1>

        <ul class="articles mt-5">

        </ul>

        <hr class="mt-3 mb-3">

        <button class="btn btn-sm" onclick="Articles__loadMore();">추가로 불러오기</button>
    </div>
</section>

<script>
    Articles__loadMore();
</script>

<%@ include file="../common/foot.jsp"%>
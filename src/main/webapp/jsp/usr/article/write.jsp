<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script>
    function Article_Write_Check(form) {
        form.title.value = form.title.value.trim();

        if(form.title.value.length == 0) {
            alert("제목을 입력해주세요.");
            form.title.focus();
            return;
        }

        form.content.value = form.content.value.trim();

        if(form.content.value.length == 0) {
            alert("내용을 입력해주세요.");
            form.content.focus();
            return;
        }

        form.submit();
    }
</script>

<%@ include file="../common/head.jsp"%>

<section>
    <div class="container px-3 mx-auto">
        <h1 class="font-bold text-lg">게시물 작성</h1>
        <form method="POST" onsubmit="ArticleSave__submitForm(this); return false;">
            <div class="flex gap-3">
                <span>제목</span>
                <div>
                    <input name="title" type="text" maxlength="50" placeholder="제목을 입력해주세요." />
                </div>
            </div>

            <div class="flex gap-3">
                <span>내용</span>
                <div>
                    <input name="content" type="text" maxlength="300" placeholder="내용을 입력해주세요." />
                </div>
            </div>

            <div>
                <div>
                    <input class="hover:underline hover:text-[red] cursor-pointer" type="submit" value="작성" />
                </div>
            </div>
        </form>
    </div>
</section>

<%@ include file="../common/foot.jsp"%>
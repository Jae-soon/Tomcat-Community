<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script>
    function Article_Write_Check(form) {
        form.title.value = form.title.value.trim();

        if(form.title.value.length == 0) {
            alert("제목을 입력해주세요.");
            form.title.focus();
            return;
        }

        form.body.value = form.body.value.trim();

        if(form.body.value.length == 0) {
            alert("내용을 입력해주세요.");
            form.title.focus();
            return;
        }

        form.submit();
    }
</script>

<h1>게시물 작성</h1>

<form onsubmit="Article_Write_Check(this); return false;">
    <div>
        <span>제목</span>
        <div>
            <input name="title" type="text" maxlength="50" placeholder="제목을 입력해주세요." />
        </div>
    </div>

    <div>
        <span>내용</span>
        <div>
            <input name="body" type="text" maxlength="300" placeholder="내용을 입력해주세요." />
        </div>
    </div>

    <div>
        <span>작성</span>
        <div>
            <input type="submit" value="작성" />
        </div>
    </div>
</form>
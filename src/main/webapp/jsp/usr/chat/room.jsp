<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../common/head.jsp"%>

<script>
    function ChatRoomSave__submitForm(form) {
        form.title.value = form.title.value.trim();
        if ( form.title.value.length == 0 ) {
            alert('제목을 입력해주세요.');
            form.title.focus();
            return;
        }
        form.content.value = form.content.value.trim();
        if ( form.content.value.length == 0 ) {
            alert('내용을 입력해주세요.');
            form.content.focus();
            return;
        }
        form.submit();
    }
</script>

<section>
    <div class="container px-3 mx-auto">
        <h1 class="font-bold text-lg">채팅방</h1>

        <div>
            ${room.title}
        </div>

        <div>
            ${room.content}
        </div>

        <script>
            function ChatMessageSave__submitForm(form) {
                form.content.value = form.content.value.trim();
                if ( form.content.value.length == 0 ) {
                    form.content.focus();
                    return false;
                }
                form.submit();
            }
        </script>

        <form onsubmit="ChatMessageSave__submitForm(this); return false;" method="POST" action="/usr/chat/writeMessage/${room.id}">
            <input autofocus name="content" type="text" placeholder="메세지를 입력해주세요." class="input input-bordered" />
            <button type="submit" value="" class="btn btn-outline btn-primary">
                작성
            </button>
        </form>

        ${messages}
    </div>
</section>

<%@ include file="../common/foot.jsp"%>
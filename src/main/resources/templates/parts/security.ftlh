<#assign
    known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getUsername()
    isAdmin = user.getAuthorities()?seq_contains('ADMIN')
    isTeacher = user.getAuthorities()?seq_contains('TEACHER')
    >
<#else>
    <#assign
    name = "unknown"
    isAdmin = false
    isTeacher = false
    >
</#if>
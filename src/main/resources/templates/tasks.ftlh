<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">

<@c.page>
    <h5>Task List</h5>
    <#if isTeacher>
        <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Add new Message
    </a>
    <div class="collapse <#if message??>show</#if>" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control ${(titleError??)?string('is-invalid', '')}"
                           value="<#if message??>${task.text}</#if>" name="title" placeholder="Введите заголовок" />
                    <#if titleError??>
                        <div class="invalid-feedback">
                            ${titleError}
                        </div>
                    </#if>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                           value="<#if message??>${task.text}</#if>" name="text" placeholder="Введите задание" />
                    <#if textError??>
                        <div class="invalid-feedback">
                            ${textError}
                        </div>
                    </#if>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control ${(objectError??)?string('is-invalid', '')}"
                           value="<#if message??>${task.object}</#if>" name="object" placeholder="Введите предмет" />
                    <#if objectError??>
                        <div class="invalid-feedback">
                            ${objectError}
                        </div>
                    </#if>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Добавить</button>
                </div>
            </form>
        </div>
    </div>
    </#if>
    <div class="card-columns">
        <#list tasks as task>
            <div class="card my-3">
                <div class="m-2">
                    <span>${task.title}</span>
                    <i>${task.text}</i>
                </div>
                <div class="card-footer text-muted">
                    ${task.object}
                </div>
            </div>
        </#list>
    </div>
</@c.page>
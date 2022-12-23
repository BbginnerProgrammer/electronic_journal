<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="row">
    <div class="col-lg-6 col-md-6 col-sm-6 container justify-content-center card">
    <h1 class="text-center"> Create New Student </h1>
    <div class="card-body">
    <div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data">
            <div class="form-group">
                <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                       value="<#if message??>${student.firstName}</#if>" name="firstName" placeholder="Введите Имя" />
                <#if textError??>
                    <div class="invalid-feedback">
                        ${textError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="text" class="form-control"
                       value="<#if message??>${student.lastName}</#if>" name="lastName" placeholder="Ведите Фамилию">
                <#if tagError??>
                    <div class="invalid-feedback">
                        ${tagError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="email" class="form-control"
                       value="<#if message??>${student.email}</#if>" name="email" placeholder="Ведите ваш Email">
                <#if emailError??>
                    <div class="invalid-feedback">
                        ${emailError}
                    </div>
                </#if>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Добавить</button>
                <a href="/student/cancel" class="btn btn-primary">Cancel</a>
            </div>
        </form>
    </div>
    </div>
    </div>
    </div>

</@c.page>
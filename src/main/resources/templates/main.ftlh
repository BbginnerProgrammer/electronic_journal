<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="row"> <h1>List Students</h1></div>
    <div class="row">
        <a href="/student/add" class="btn btn-primary mt-3 mb-3">Add student</a>
    </div>

    <table class="table table-sm table-bordered" id='table'>
        <thead>
        <tr>
            <th>№</th>
            <th>Студент</th>
            <th>Математика</th>
            <th>Русский язык</th>
            <th>Английский язык</th>
            <th>Физическая культура</th>
        </tr>
        </thead>
        <tbody>
        <#if isTeacher>
            <#list students as key, values>
            <tr>
                    <td>${key?index + 1}</td>
                    <td>${key.firstName} ${key.lastName} </td>
                    <#list values as value>
                        <td contenteditable="true"
                            class='edit'
                            id='math:${value.id}'>${value.math}</td>
                        <td contenteditable="true"
                            class='edit'
                            id='russian:${value.id}'>${value.russian}</td>
                        <td contenteditable="true"
                            class='edit'
                            id='english:${value.id}'>${value.english}</td>
                        <td contenteditable="true"
                            class='edit'
                            id='physical_education:${value.id}'>${value.physical_education}</td>

                    </#list>
            </tr>
            </#list>
        </#if>
        <#if !isTeacher>
            <#list students as key, values>
                <tr>
                    <td>${key?index + 1}</td>
                    <td>${key.firstName} ${key.lastName} </td>
                    <#list values as value>
                        <td id='math:${value.id}'>${value.math}</td>
                        <td id='russian:${value.id}'>${value.russian}</td>
                        <td id='english:${value.id}'>${value.english}</td>
                        <td id='physical_education:${value.id}'>${value.physical_education}</td>

                    </#list>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>

</@c.page>
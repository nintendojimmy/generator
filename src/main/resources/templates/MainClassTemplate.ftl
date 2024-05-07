package ${packageName};

${importStatements};

${annotations}
public class ${className} ${extendsDeclaration} ${implementsDeclaration}{

    <#list fields as field>
    private String ${field};
    </#list>

    public ${className}() {
        // Initialize fields here
    }

    <#list fields as field>
    // Getter for ${field}
    public String get${field?cap_first}() {
        return this.${field};
    }

    // Setter for ${field}
    public void set${field?cap_first}(String ${field}) {
        this.${field} = ${field};
    }
    </#list>

    // SpEL method
    public void spelMethod() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'");
        String message = (String) exp.getValue();
        System.out.println(message);
    }
}
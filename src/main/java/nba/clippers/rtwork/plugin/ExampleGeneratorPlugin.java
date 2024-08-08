package nba.clippers.rtwork.plugin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class ExampleGeneratorPlugin extends PluginAdapter {

    public ExampleGeneratorPlugin(){}

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        moveExampleFile(topLevelClass);
        return true;
    }

    private void moveExampleFile(TopLevelClass topLevelClass) {
        String exampleTargetPackage = "nba.clippers.rtwork.db.modelExample";
        String sourceDir = "src/main/java/";
        String exampleDir = sourceDir + exampleTargetPackage.replace('.', '/');

        // 创建目标目录
        try {
            Files.createDirectories(Paths.get(exampleDir));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 生成的 Example 类文件路径
        String oldPathStrs = "nba.clippers.rtwork.db.modelExample";
        // String oldPathStr = sourceDir + topLevelClass.getType().getPackageName().replace('.', '/') + "/" + topLevelClass.getType().getShortName() + ".java";
        String oldPathStr = sourceDir + oldPathStrs.replace('.', '/') + ".java";
        Path oldPath = Paths.get(oldPathStr);

        // 新的 Example 类文件路径
        String newPathStr = exampleDir + "/" + topLevelClass.getType().getShortName() + ".java";
        Path newPath = Paths.get(newPathStr);

        // 移动文件
        try {
            Files.move(oldPath, newPath);
            System.out.println("Moved: " + oldPathStr + " to " + newPathStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

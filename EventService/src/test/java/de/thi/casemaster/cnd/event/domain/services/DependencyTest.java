package de.thi.casemaster.cnd.event.domain.services;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@RunWith(ArchUnitRunner.class) // Remove this line for JUnit 5!!
@AnalyzeClasses(packages = "de.thi.casemaster.cnd.event")
public class DependencyTest {
    @ArchTest
    static final ArchRule REST_SHOULD_NOT_ACCESS_JPA = noClasses().that().resideInAPackage("..adapter.api..")
            .should().accessClassesThat().resideInAPackage("..adapter.jpa..");
    @ArchTest
    static final ArchRule JPA_SHOULD_NOT_ACCESS_REST = noClasses().that().resideInAPackage("..adapter.jpa..")
            .should().accessClassesThat().resideInAPackage("..adapter.api..");
}

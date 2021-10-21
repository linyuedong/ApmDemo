package com.me.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.Project;


class TestPlugin  implements Plugin<Project>{

    @Override
    public void apply(Project project) {
        System.out.println("this is TestPlugin");
    }
}

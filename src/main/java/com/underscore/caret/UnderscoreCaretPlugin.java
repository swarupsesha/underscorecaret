package com.underscore.caret;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.editor.CaretVisualAttributes;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.editor.event.EditorFactoryEvent;
import com.intellij.openapi.editor.event.EditorFactoryListener;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Arrays;

import static com.intellij.openapi.editor.CaretVisualAttributes.Shape.UNDERSCORE;
import static com.intellij.openapi.editor.CaretVisualAttributes.Weight.THIN;

public class UnderscoreCaretPlugin extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        EditorFactoryListener editorFactoryListener = new EditorFactoryListener() {
            @Override
            public void editorCreated(@NotNull EditorFactoryEvent editorFactoryEvent) {
                Arrays.stream(EditorFactory.getInstance().getAllEditors()).forEach(editor -> {
                    editor.getCaretModel().getCurrentCaret().setVisualAttributes(new CaretVisualAttributes(new Color(220, 250, 138), THIN, UNDERSCORE, 0.1f));
                });
            }
        };
        EditorFactory.getInstance().addEditorFactoryListener(editorFactoryListener, () -> {});
    }
}

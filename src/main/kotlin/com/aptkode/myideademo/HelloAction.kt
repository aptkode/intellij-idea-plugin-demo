package com.aptkode.myideademo

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.fileChooser.FileChooser
import com.intellij.openapi.fileChooser.FileChooserDescriptor
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.ui.popup.JBPopupFactory
import com.intellij.util.Consumer

/**
 * 16/07/2019
 *
 * @author Ruwanka
 *
 *
 */
class HelloAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val myIdeaDemoPopupList =
            MyIdeaDemoPopupList("my-idea-list", mutableListOf("apple", "orange", "pineapple", "guava"))
        if (e.project != null) {
            JBPopupFactory.getInstance().createListPopup(myIdeaDemoPopupList, 5)
                .showCenteredInCurrentWindow(e.project!!)
        }
    }

    private fun showCustomDialog() {
        val myIdeaDataDialogWrapper = MyIdeaDataDialogWrapper()
        if (myIdeaDataDialogWrapper.showAndGet()) {
            myIdeaDataDialogWrapper.close(23)
        }
    }

    private fun getUserName(e: AnActionEvent) {
        val name =
            Messages.showInputDialog(e.project, "Enter your name", "MyIdeaDemo Data", Messages.getQuestionIcon())
        Messages.showMessageDialog(e.project, "your name is $name", "MyIdeaDemo", Messages.getInformationIcon())
    }

    private fun showFileDialog(e: AnActionEvent) {
        val fileChooserDescriptor = FileChooserDescriptor(
            false,
            true,
            false,
            false,
            false,
            false
        )
        fileChooserDescriptor.title = "MyIdeaDemo Pick Directory"
        fileChooserDescriptor.description = "My file chooser demo"

        FileChooser.chooseFile(fileChooserDescriptor, e.project, null, Consumer {
            Messages.showMessageDialog(e.project, it.path, "Path", Messages.getInformationIcon())
        })
    }
}
package com.aptkode.myideademo

import com.intellij.openapi.ui.popup.PopupStep
import com.intellij.openapi.ui.popup.util.BaseListPopupStep as BaseListPopupStep1

/**
 * 14/08/2019
 *
 * @author Ruwanka
 *
 *
 */
class MyIdeaDemoPopupList(title: String, fruits: List<String>) : BaseListPopupStep1<String>(title, fruits) {

    override fun isSpeedSearchEnabled(): Boolean {
        return true
    }

    override fun onChosen(selectedValue: String?, finalChoice: Boolean): PopupStep<*> {
        print("")
        return PopupStep.FINAL_CHOICE
    }
}
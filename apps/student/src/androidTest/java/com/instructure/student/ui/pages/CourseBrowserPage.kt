package com.instructure.student.ui.pages

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.instructure.espresso.click
import com.instructure.espresso.page.BasePage
import com.instructure.student.R
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf

class CourseBrowserPage : BasePage(R.id.courseBrowserPage) {

    fun selectAssignments() {
        val matcher = allOf(withText("Assignments"))
        selectSection(matcher)
    }

    private fun selectSection(matcher: Matcher<View>) {
        // Scroll RecyclerView item into view, if necessary
        onView(allOf(withId(R.id.courseBrowserRecyclerView), isDisplayed()))
                .perform(RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>(hasDescendant(matcher)))

        onView(matcher).click()
    }
}
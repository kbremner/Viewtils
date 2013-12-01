package com.deftech.viewtils.test;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import static com.deftech.viewtils.Helper.with;
import static com.deftech.viewtils.matchers.BaseMatcher.any;
import static com.deftech.viewtils.matchers.BaseMatcher.is;
import static com.deftech.viewtils.test.TestUtil.createActivity;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = "src/test/resources/AndroidManifest.xml")
public class BaseMatcherTests {
    @Test
    public void testMatcherIs() throws Exception {
        Activity activity = createActivity();
        Button b = with(activity).find(Button.class).where(is(activity.findViewById(R.id.button)));
        assertNotNull(b);
        assertEquals(b, activity.findViewById(R.id.button));
    }

    @Test
    public void testFindAllViews(){
        List<View> results = with(createActivity()).find(View.class).allWhere(any());
        assertEquals(results.size(), 3);  // LinearLayout, Button, TextView
    }
}

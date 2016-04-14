package labpi.convenios.androidapp;

import android.support.v4.view.ViewPager;
import android.view.View;

public class IntroPageTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {

        int pagePosition = (int) page.getTag();

        int pageWidth = page.getWidth();
        float offset = pageWidth * position;
        float absPosition = Math.abs(position);

        if(position > -1.0f && position < 1.0f) {

            View description = page.findViewById(R.id.action_call);
            description.setAlpha(1.0f - absPosition);
            description.setTranslationY(offset * 0.1f);

            View image = page.findViewById(R.id.brasiliaImage);
            if (pagePosition == 0 && image != null) {
                image.setTranslationX(-offset * 0.5f);
            }
        }
    }
}
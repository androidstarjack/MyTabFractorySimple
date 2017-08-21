package drg.yyh.cn.mytabfractorysimple.adapter;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;



/**
 * Created by Administrator on 2017/8/21/021.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {
    public SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }

//    private Context context;
//    // TabLayout title
//    private String tabTitles[] = new String[]{"TAB1", "TAB2", "TAB3"};
//    // TabLayout 图标
//    private int[] imageResId = {R.mipmap.icon_tab,
//            R.mipmap.icon_tab,
//            R.mipmap.icon_tab};
//
//    public SimpleFragmentPagerAdapter(FragmentManager fm, Context context) {
//        super(fm);
//        this.context = context;
//    }
//
//    @Override
//    public Fragment getItem(int position) {
//        return PageFragment.newInstance(position + 1);
//    }
//
//    @Override
//    public int getCount() {
//        return tabTitles.length;
//    }
//
//    @Override
//    public CharSequence getPageTitle(int position) {
//        // 返回纯文字
//        // return tabTitles[position];
//
//        // 返回ICON和文字
//        Drawable image = context.getResources().getDrawable(imageResId[position]);
//        image.setBounds(0, 0, image.getIntrinsicWidth() * 2, image.getIntrinsicHeight() * 2);
//        SpannableString sb = new SpannableString(tabTitles[position]);
//        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
//        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        return sb;
//    }
//
//    /**
//     * 自定义TabLayout title
//     * @param position
//     * @return
//     */
//    public View getTabView(int position){
//        View view = LayoutInflater.from(context).inflate(R.layout.view_sxp_tab_title, null);
//        TextView tv= (TextView) view.findViewById(R.id.textView);
//        tv.setText(tabTitles[position]);
//        ImageView img = (ImageView) view.findViewById(R.id.imageView);
//        img.setImageResource(imageResId[position]);
//        return view;
//    }

}
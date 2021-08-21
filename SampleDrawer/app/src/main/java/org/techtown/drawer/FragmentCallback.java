package org.techtown.drawer;

import android.os.Bundle;

public interface FragmentCallback {

    // 어떤 프로래그먼트를 보여줄지 선택하는 메서드
    public void onFragmentSelected(int position, Bundle bundle);
}

/**
 * Copyright 2015 bingoogolapple
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.bingoogolapple.androidcommon.adapter;

import android.view.View;
import android.view.ViewGroup;

/**
 * @author JeremyHwc;
 * @date 2017/10/18/018 17:37;
 * @email jeremy_hwc@163.com ;
 * @desc AdapterView和RecyclerView的item中子控件点击事件监听器
 */
public interface BGAOnItemChildClickListener {
    void onItemChildClick(ViewGroup parent, View childView, int position);
}
/*
 * Copyright (C) 2020-2024 The LineageOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.lineageos.settings.popupcamera;

import android.os.Bundle;
import android.provider.Settings;

import androidx.preference.Preference;
import androidx.preference.Preference.OnPreferenceChangeListener;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreference;

import org.lineageos.settings.R;

public class PopupCameraSettingsFragment extends PreferenceFragmentCompat implements
        OnPreferenceChangeListener {

    private SwitchPreference mAlwaysCameraSwitch;
    public static final String KEY_ALWAYS_CAMERA_DIALOG = "always_on_camera_dialog";

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.popup_settings);

        mAlwaysCameraSwitch = (SwitchPreference) findPreference(KEY_ALWAYS_CAMERA_DIALOG);
        boolean enabled = Settings.System.getInt(getContext().getContentResolver(),KEY_ALWAYS_CAMERA_DIALOG, 0) == 1;
        mAlwaysCameraSwitch.setChecked(enabled);
        mAlwaysCameraSwitch.setOnPreferenceChangeListener(this);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        if (preference == mAlwaysCameraSwitch) {
            boolean enabled = (Boolean) newValue;
            Settings.System.putInt(getContext().getContentResolver(),
                KEY_ALWAYS_CAMERA_DIALOG,
                enabled ? 1 : 0);
        }
        return true;
    }
}

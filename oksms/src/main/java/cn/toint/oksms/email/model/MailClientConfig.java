/*
 * Copyright 2025 Toint (599818663@qq.com)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.toint.oksms.email.model;

import cn.hutool.v7.extra.mail.MailAccount;

import java.io.PrintStream;
import java.util.Objects;

public class MailClientConfig extends MailAccount {

    /**
     * 全局共享Session
     */
    private boolean useGlobalSession;

    /**
     * 邮件调试输出
     */
    private PrintStream debugOutput;

    public boolean isUseGlobalSession() {
        return useGlobalSession;
    }

    public void setUseGlobalSession(boolean useGlobalSession) {
        this.useGlobalSession = useGlobalSession;
    }

    public PrintStream getDebugOutput() {
        return debugOutput;
    }

    public void setDebugOutput(PrintStream debugOutput) {
        this.debugOutput = debugOutput;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        MailClientConfig that = (MailClientConfig) object;
        return useGlobalSession == that.useGlobalSession && Objects.equals(debugOutput, that.debugOutput);
    }

    @Override
    public int hashCode() {
        return Objects.hash(useGlobalSession, debugOutput);
    }
}

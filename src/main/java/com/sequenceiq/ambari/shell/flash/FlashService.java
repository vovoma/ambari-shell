/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sequenceiq.ambari.shell.flash;

import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.core.JLineShellComponent;
import org.springframework.stereotype.Service;

import com.sequenceiq.ambari.client.AmbariClient;

/**
 * Service for managing the flashes.
 */
@Service
public class FlashService {

  private AmbariClient client;
  private JLineShellComponent shell;
  private ExecutorService executorService;

  @Autowired
  public FlashService(AmbariClient client, JLineShellComponent shell, ExecutorService executorService) {
    this.client = client;
    this.shell = shell;
    this.executorService = executorService;
  }

  public void showInstallProgress(boolean exit) {
    executorService.submit(new InstallProgress(shell, client, exit));
  }
}

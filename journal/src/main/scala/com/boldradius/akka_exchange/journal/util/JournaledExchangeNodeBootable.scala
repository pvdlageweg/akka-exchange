/**
 * Copyright © 2015, BoldRadius Solutions
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
package com.boldradius.akka_exchange.journal.util

import com.boldradius.akka_exchange.journal.SharedJournalFinder
import com.boldradius.akka_exchange.util.ExchangeNodeBootable


abstract class JournaledExchangeNodeBootable extends ExchangeNodeBootable {

  val findJournal: Boolean = true

  val persistentJournal = {
    println("Booting up Journal Finder...")
    system.actorOf(
      SharedJournalFinder.props,
      SharedJournalFinder.name
    )
  }

}

/*
 * Copyright (c) 2015 Memorial Sloan-Kettering Cancer Center.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY, WITHOUT EVEN THE IMPLIED WARRANTY OF MERCHANTABILITY OR FITNESS
 * FOR A PARTICULAR PURPOSE. The software and documentation provided hereunder
 * is on an "as is" basis, and Memorial Sloan-Kettering Cancer Center has no
 * obligations to provide maintenance, support, updates, enhancements or
 * modifications. In no event shall Memorial Sloan-Kettering Cancer Center be
 * liable to any party for direct, indirect, special, incidental or
 * consequential damages, including lost profits, arising out of the use of this
 * software and its documentation, even if Memorial Sloan-Kettering Cancer
 * Center has been advised of the possibility of such damage.
 */

/*
 * This file is part of cBioPortal.
 *
 * cBioPortal is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package org.mskcc.cbio.portal.scripts;

import org.mskcc.cbio.portal.dao.DaoPatientList;
import org.mskcc.cbio.portal.model.PatientList;
import org.mskcc.cbio.portal.util.ProgressMonitor;

import java.util.ArrayList;

/**
 * Command Line Tool to Export All Patient Lists to the Console.
 */
public class GetAllPatientLists {

    public static void main(String[] args) throws Exception {
        // an extra --noprogress option can be given to avoid the messages regarding memory usage and % complete
        ProgressMonitor.setConsoleModeAndParseShowProgress(args);
        DaoPatientList daoPatientList = new DaoPatientList();
        ArrayList <PatientList> patientListMaster = daoPatientList.getAllPatientLists();
        for (PatientList patientList:  patientListMaster) {
            System.out.println (patientList.getPatientListId() + ": "
                    + patientList.getStableId() + ": " + patientList.getName());
        }
    }
}
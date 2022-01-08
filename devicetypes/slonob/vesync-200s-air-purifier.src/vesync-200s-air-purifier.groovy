/**
 *  VeSync 200S Air Purifier
 *
 *  Copyright 2022 Jarrod Stenberg
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 */
metadata {
	definition (name: "VeSync 200S Air Purifier", namespace: "slonob", author: "Jarrod Stenberg", cstHandler: true) {
		capability "Air Purifier Fan Mode"
		capability "Fan Speed"
		capability "Filter State"
		capability "Filter Status"
		capability "Firmware Update"
		capability "Mode"
		capability "Operating State"
		capability "Switch"
		capability "Switch Level"
	}


	simulator {
		// TODO: define status and reply messages here
	}

	tiles {
		// TODO: define your main and details tiles here
	}
}

// parse events into attributes
def parse(String description) {
	log.debug "Parsing '${description}'"
	// TODO: handle 'airPurifierFanMode' attribute
	// TODO: handle 'supportedAirPurifierFanModes' attribute
	// TODO: handle 'fanSpeed' attribute
	// TODO: handle 'filterLifeRemaining' attribute
	// TODO: handle 'filterStatus' attribute
	// TODO: handle 'availableVersion' attribute
	// TODO: handle 'currentVersion' attribute
	// TODO: handle 'lastUpdateTime' attribute
	// TODO: handle 'lastUpdateStatus' attribute
	// TODO: handle 'lastUpdateStatusReason' attribute
	// TODO: handle 'state' attribute
	// TODO: handle 'mode' attribute
	// TODO: handle 'supportedModes' attribute
	// TODO: handle 'machineState' attribute
	// TODO: handle 'supportedMachineStates' attribute
	// TODO: handle 'switch' attribute
	// TODO: handle 'level' attribute

}

// handle commands
def setAirPurifierFanMode() {
	log.debug "Executing 'setAirPurifierFanMode'"
	// TODO: handle 'setAirPurifierFanMode' command
}

def setFanSpeed() {
	log.debug "Executing 'setFanSpeed'"
	// TODO: handle 'setFanSpeed' command
}

def checkForFirmwareUpdate() {
	log.debug "Executing 'checkForFirmwareUpdate'"
	// TODO: handle 'checkForFirmwareUpdate' command
}

def updateFirmware() {
	log.debug "Executing 'updateFirmware'"
	// TODO: handle 'updateFirmware' command
}

def setMode() {
	log.debug "Executing 'setMode'"
	// TODO: handle 'setMode' command
}

def setMachineState() {
	log.debug "Executing 'setMachineState'"
	// TODO: handle 'setMachineState' command
}

def on() {
	log.debug "Executing 'on'"
	// TODO: handle 'on' command
}

def off() {
	log.debug "Executing 'off'"
	// TODO: handle 'off' command
}

def setLevel() {
	log.debug "Executing 'setLevel'"
	// TODO: handle 'setLevel' command
}
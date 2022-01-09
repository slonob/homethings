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
		command "lowSpeed"
		command "medSpeed"
		command "highSpeed"

		attribute "currentState", "string"
		attribute "cid", "string"
		attribute "token", "string"
        attribute "accountID", "number"
		attribute "accountData", "enum"
    }


	simulator {
		// TODO: define status and reply messages here
	}

	tiles(scale: 2) {
		multiAttributeTile(name:"switch", type: "lighting", width: 6, height: 4, canChangeIcon: true){
			tileAttribute ("device.switch", key: "PRIMARY_CONTROL") {    
				attributeState "on", action:"switch.off", label:'ON', icon:"st.Lighting.light24", backgroundColor:"#00A0DC", nextState:"turningOff"
				attributeState "off", action:"switch.on", label:'OFF', icon:"st.Lighting.light24", backgroundColor:"#ffffff", nextState:"turningOn"
				attributeState "turningOn", label:'TURNINGON', icon:"st.Lighting.light24", backgroundColor:"#f0b823", nextState: "turningOn"
				attributeState "turningOff", label:'TURNINGOFF', icon:"st.Lighting.light24", backgroundColor:"#f0b823", nextState: "turningOff"
			}   
            tileAttribute ("device.currentState", key: "SECONDARY_CONTROL") {
           		attributeState "LOW", label:'Fan speed set to LOW', icon:"st.Lighting.light24"
                attributeState "MED", label:'Fan speed set to MEDIUM', icon:"st.Lighting.light24"
                attributeState "HIGH", label:'Fan speed set to HIGH', icon:"st.Lighting.light24"
            }
			tileAttribute ("device.level", key: "SLIDER_CONTROL") {
				attributeState "level", action:"switch level.setLevel"
			}
		}
		standardTile("lowSpeed", "device.currentState", inactiveLabel: false, decoration: "flat", width: 2, height: 2) {
			state "LOW", label:'LOW', action: "lowSpeed", icon:"st.Home.home30"
  		}
		standardTile("medSpeed", "device.currentState", inactiveLabel: false, decoration: "flat", width: 2, height: 2) {
			state "MED", label: 'MED', action: "medSpeed", icon:"st.Home.home30"
		}
		standardTile("highSpeed", "device.currentState", inactiveLabel: false, decoration: "flat", width: 2, height: 2) {
			state "HIGH", label: 'HIGH', action: "highSpeed", icon:"st.Home.home30"
		}
		standardTile("indicator", "device.indicatorStatus", width: 3, height: 2, inactiveLabel: false, decoration: "flat") {
			state "when off", action:"indicator.indicatorWhenOn", icon:"st.indicators.lit-when-off"
			state "when on", action:"indicator.indicatorNever", icon:"st.indicators.lit-when-on"
			state "never", action:"indicator.indicatorWhenOff", icon:"st.indicators.never-lit"
		}
		standardTile("refresh", "device.switch", width: 6, height: 2, inactiveLabel: false, decoration: "flat") {
			state "default", label:'Refresh', action:"refresh.refresh", icon:"st.secondary.refresh-icon"
		}
		main(["switch"])
		details(["switch", "lowSpeed", "medSpeed", "highSpeed", "refresh"])
	}
}

preferences {
	section("VeSync Device") {
		// TODO: put inputs here
        input("username", "string", title: "VeSync Username", description: "VeSync username (e.g., foo@bar.com)", required: true, displayDuringSetup: true)
        input("password", "password", title: "VeSync Password", description: "VeSync password", required: true, displayDuringSetup: true)
        input("loginData", "list", title: "VeSync Login Data", description: "", required: false, displayDuringSetup: false)
        input("macid", "string", title: "MAC Address", description: "MAC Address (see settings/device info)", required: true, displayDuringSetup: true)
        input("fanSpeed", "capability.fanSpeed", title: "fanSpeed", description: "Fan Speed", required: true, displayDuringSetup: false)
	}
}

include 'asynchttp'
import groovy.json.JsonSlurper
import groovy.transform.Field
import java.security.MessageDigest

@Field final String API_URL = "https://smartapi.vesync.com:443"


def initialize() {
   subscribe(fanSpeed, "fanSpeed", eventHandler)
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

def setFanSpeed(speed) {
	log.debug "Executing 'setFanSpeed'" + speed
    
    sendEvent(name: "fanSpeed", value: speed)
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
	log.trace "Executing 'on()'..."
	
    parseResponse(callURL('devicecontrol-power', true))
	
	sendEvent(name: "switch", value: "on")
}

def off() {
	log.trace "Executing 'off()'..."
	
    parseResponse(callURL('devicecontrol-power', false))
    
	sendEvent(name: "switch", value: "off")
}

def parseResponse(response) {
	log.debug "parseResponse input:" + response.data
	def d = response.data
	log.debug "returned msg: " + d.msg
	log.debug "returned HTTP code: " + response.status

}

def setLevel(value) {
	log.debug "Executing 'setLevel' to " + value
	// TODO: handle 'setLevel' command
}

//
def eventHandler(evt) {
	log.debug evt
    def fanSpeed = evt.device.currentState('fanSpeed')
    log.debug "get fanspeed current state '${fanSpeed}'"
}

// TODO: implement event handlers
def callURL(apiAction, details) {
	log.trace "Executing 'callURL($apiAction, $details)'..."
	
	// log.trace "[SETTINGS] APIKEY=${settings.apikey}, ID=${settings.deviceID}, MODEL=${settings.modelNum}"
	
    def params
	if(apiAction == 'devices') {
		def login = getLoginData()
        log.debug login
        params = [
            method: 'POST',
            uri   : API_URL,
            path  : '/cloud/v1/deviceManaged/devices',
			headers: ["Content-Type": "application/json"],
            body: [
                "timeZone": "CDT",
                "acceptLanguage": "en",
                "accountID": login.accountID,
                "token": login.token,
                "content-type": "application/json",
                "appVersion": "2.5.1",
                "phoneBrand": "SM N9005",
                "phoneOS": "Android",
                "traceId": timestamp(),
                "method": "devices",
                "pageNo": 1,
                "pageSize": 100
            ]
        ]
	} else if(apiAction == 'devicestate') {
        params = [
            method: 'GET',
            uri   : API_URL,
            path  : '/v1/devices/state',
			headers: ["User_agent": "VeSync/VeSync 3.0.51(F5321;Android 8.0.0)", "Content-Type": "application/json; charset=UTF-8"],
			query: [device: settings.deviceID, model: settings.modelNum],
        ]
	} else if(apiAction == 'devicecontrol-power') {
		def login = getLoginData()
        def deviceData = getDeviceData()
        log.debug login
		params = [
            method: 'POST',
            uri   : API_URL,
            path  : '/cloud/v2/deviceManaged/bypassV2',
			headers: ["User_agent": "VeSync/VeSync 3.0.51(F5321;Android 8.0.0)", "Content-Type": "application/json; charset=UTF-8"],
			contentType: "application/json; charset=UTF-8",
			body: [
                "method": "bypassV2",
                "debugMode": false,
                "deviceRegion": "US",
                "timeZone": "CDT",
                "acceptLanguage": "en",
                "accountID": login.accountID,
                "token": login.token,
                "appVersion": "2.5.1",
                "phoneBrand": "SM N9005",
                "phoneOS": "Android",
                "traceId": timestamp(),
                "cid": deviceData.cid,
                "configModule": "",
                "payload": [
                        "data": [
                            "enabled": details,
                            "id": 0
                        ],
                        "method": "setSwitch",
                        "source": "APP"
                ]
			]
,
        ]
	} else if(apiAction == 'login') {
    	log.debug "username: ${username}"
    	log.debug "password: ${password}"
        
        params = [
            method: 'POST',
            uri   : API_URL,
            path  : '/cloud/v1/user/login',
			headers: ["User_agent": "VeSync/VeSync 3.0.51(F5321;Android 8.0.0)", "Content-Type": "application/json; charset=UTF-8"],
			contentType: "application/json; charset=UTF-8",
			body: [
                "timeZone": "CDT",
                "acceptLanguage": "en",
                "email": username,
                "password": MD5(password),
                "userType": 1,
                "method": "login",
                "devToken": "",
                "appVersion": "2.5.1",
                "phoneBrand": "SM N9005",
                "phoneOS": "Android",
                "traceId": timestamp()
            ]
        ]
	} else if(apiAction == 'devicecontrol-brightness') {
        params = [
            method: 'PUT',
            uri   : API_URL,
            path  : '/v1/devices/control',
			headers: ["Content-Type": "application/json"],
			contentType: "application/json",
			body: [device: settings.deviceID, model: settings.modelNum, cmd: ["name": "brightness", "value": details]],
        ]
    }
    
	
    log.debug params
    log.debug "APIACTION=${apiAction}"
    log.debug "METHOD=${params.method}"
    log.debug "URI=${params.uri}${params.path}"
    log.debug "HEADERS=${params.headers}"
    log.debug "QUERY=${params.query}"
    log.debug "BODY=${params.body}"
	
	
	try {
		if(params.method == 'GET') {
			httpGet(params) { resp ->
				//log.debug "RESP="
				//log.debug "HEADERS="+resp.headers
				//log.debug "DATA="+resp.data
				
				log.debug "response.data="+resp.data
				
				return resp.data
			}
		} else if(params.method == 'PUT') {
			httpPutJson(params) { resp ->
				//log debug "RESP="
				//log.debug "HEADERS="+resp.headers
				//log.debug "DATA="+resp.data
				
				log.debug "response.data="+resp.data
				
				return resp.data
			}
		} else if(params.method == 'POST') {
			httpPostJson(params) { resp ->
				log.debug "response.data="+resp.data
				// This returns the data
                resp
			}
		}
	} catch (groovyx.net.http.HttpResponseException e) {
		log.error "callURL() >>>>>>>>>>>>>>>> ERROR >>>>>>>>>>>>>>>>"
		log.error "Error: e.statusCode ${e.statusCode}"
		log.error "${e}"
		log.error "callURL() <<<<<<<<<<<<<<<< ERROR <<<<<<<<<<<<<<<<"
		
		return 'unknown'
	}
}

def getLoginData() {
	log.trace "Executing 'getLoginData()'..."
	
    def r = callURL('login', "")
    log.debug r.data
    r.data.result
}

def getDeviceData() {
	log.trace "Executing 'getDeviceData()'..."
	
    def r = callURL('devices', "")
    log.debug r.data

	// Return first match with MAC
    r.data.result.list.each { it.macID == macid }[0]
}


def MD5(s) {
	def digest = MessageDigest.getInstance("MD5")
	new BigInteger(1,digest.digest(s.getBytes())).toString(16).padLeft(32,"0")
} 

def timestamp() {
	Calendar.getInstance(TimeZone.getTimeZone('GMT')).getTimeInMillis().toString().substring(0,10)
}
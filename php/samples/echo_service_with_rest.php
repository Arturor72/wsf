<?php
/*
 * Copyright 2005,2007 WSO2, Inc. http://wso2.com
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

function echoFunction($inMessage) {

    $outMessage = new WSMessage($inMessage->str);

    return $outMessage;
}

$operations = array("echoString" => "echoFunction");
$restmap = array ("echoString"=>array("HTTPMethod"=>"GET","restLocation"=> "a/b"));
$service = new WSService(array("operations" => $operations, "RESTMaping"=>$restmap));
$service->reply($requestPayloadString);

?>
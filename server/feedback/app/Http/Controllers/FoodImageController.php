<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class FoodImageController extends Controller
{
    public function store(Request $request)
    {
        $path = $request->file('avatar')->store('avatars');

        return $path;
    }
}

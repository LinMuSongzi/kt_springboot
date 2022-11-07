package com.msz.demo.service

import com.msz.demo.info.respone.EffectsBean
import com.msz.demo.info.respone.RespondInfo
import com.msz.demo.info.respone.simple
import org.springframework.stereotype.Service


private val EFFECTS_ARRAY :RespondInfo<List<EffectsBean>> = simple(data = arrayListOf<EffectsBean>().apply {
    var titleOne = EffectsBean("滤波器类", e_child = buildEffectRealData("滤波器类"))
    add(titleOne)
    titleOne = EffectsBean("合成效果器", e_child = buildEffectRealData("合成效果器"))
    add(titleOne)
    titleOne = EffectsBean("音量效果器", e_child = buildEffectRealData("音量效果器"))
    add(titleOne)
    titleOne = EffectsBean("剪辑效果器", e_child = buildEffectRealData("剪辑效果器"))
    add(titleOne)
    titleOne = EffectsBean("混音效果器", e_child = buildEffectRealData("混音效果器"))
    add(titleOne)
    titleOne = EffectsBean("节奏和音高效果器", e_child = buildEffectRealData("节奏和音高效果器"))
    add(titleOne)
    titleOne = EffectsBean("主线路效果器", e_child = buildEffectRealData("主线路效果器"))
    add(titleOne)
    titleOne = EffectsBean("特殊效果器", e_child = buildEffectRealData("特殊效果器"))
    add(titleOne)
    titleOne = EffectsBean("其他", e_child = buildEffectRealData("其他"))
    add(titleOne)
})
private fun buildEffectRealData(s: String): List<EffectsBean>? {
    val list:ArrayList<EffectsBean> = arrayListOf()
    /**
     *
    childBean = EffectsBean(c_name = "11111", e_name = "11111", content = "1111111")
    list.add(childBean)
     *
     */
    var childBean: EffectsBean
    when(s){
        "滤波器类"->{
            childBean = EffectsBean(c_name = "通用?", e_name = "allpass", content = "RBJ all-pass biquad IIR filter")
            list.add(childBean)
            childBean = EffectsBean(c_name = "带通滤波器", e_name = "bandpass", content = "RBJ band-pass biquad IIR filter")
            list.add(childBean)
            childBean = EffectsBean(c_name = "带阻滤波器", e_name = "bandreject", content = "RBJ band-reject biquad IIR filter")
            list.add(childBean)
            childBean = EffectsBean(c_name = "乐队?", e_name = "band", content = "SPKit resonator band-pass IIR filter")
            list.add(childBean)
            childBean = EffectsBean(c_name = "贝斯", e_name = "bass", content = "Tone control: RBJ shelving biquad IIR filter")
            list.add(childBean)
            childBean = EffectsBean(c_name = "均衡器", e_name = "equalizer", content = "RBJ peaking equalisation biquad IIR filter")
            list.add(childBean)
            childBean = EffectsBean(c_name = "FFT卷积FIR滤波器", e_name = "firfit+", content = "FFT convolution FIR filter using given freq. response")
            list.add(childBean)
            childBean = EffectsBean(c_name = "高通滤波", e_name = "highpass", content = "High-pass filter: Single pole or RBJ biquad IIR")
            list.add(childBean)
            childBean = EffectsBean(c_name = "希尔伯特变换滤波器", e_name = "hilbert", content = "Hilbert transform filter (90 degrees phase shift)")
            list.add(childBean)
            childBean = EffectsBean(c_name = "低通滤波器", e_name = "lowpass", content = "Low-pass filter: single pole or RBJ biquad IIR")
            list.add(childBean)
            childBean = EffectsBean(c_name = "高通/带通/抑制FIR", e_name = "sinc", content = "Sinc-windowed low/high-pass/band-pass/reject FIR")
            list.add(childBean)
            childBean = EffectsBean(c_name = "高音", e_name = "treble", content = "Tone control: RBJ shelving biquad IIR filter")
            list.add(childBean)
        }
        "合成效果器"->{
            childBean = EffectsBean(c_name = "混合", e_name = "chorus", content = "Make a single instrument sound like many")
            list.add(childBean)
            childBean = EffectsBean(c_name = "延迟效果", e_name = "delay", content = "Delay one or more channels")
            list.add(childBean)
            childBean = EffectsBean(c_name = "回音/回想", e_name = "echo", content = "Add an echo")
            list.add(childBean)
            childBean = EffectsBean(c_name = "回音/回想 多个", e_name = "echos", content = "Add a sequence of echos")
            list.add(childBean)
            childBean = EffectsBean(c_name = "立体声?", e_name = "flanger", content = "Stereo flanger")
            list.add(childBean)
            childBean = EffectsBean(c_name = "非线性失真?", e_name = "overdrive", content = "Non-linear distortion")
            list.add(childBean)
            childBean = EffectsBean(c_name = "相位器", e_name = "phaser", content = "Phase shifter")
            list.add(childBean)
            childBean = EffectsBean(c_name = "音频重复", e_name = "repeat", content = "Loop the audio a number of times")
            list.add(childBean)
            childBean = EffectsBean(c_name = "混响", e_name = "reverb", content = "Add reverberation")
            list.add(childBean)
            childBean = EffectsBean(c_name = "颠倒", e_name = "reverse", content = "Reverse the audio (to search for Satanic messages")
            list.add(childBean)
            childBean = EffectsBean(c_name = "颤音/震音", e_name = "tremolo", content = "Sinusoidal volume modulation")
            list.add(childBean)
        }
        "音量效果器"->{
            childBean = EffectsBean(c_name = "压伸", e_name = "compand", content = "Signal level compression/expansion/limiting")
            list.add(childBean)
            childBean = EffectsBean(c_name = "差异/对比", e_name = "contrast", content = "Phase contrast volume enhancement")
            list.add(childBean)
            childBean = EffectsBean(c_name = "直流偏移", e_name = "dcshift", content = "Apply or remove DC offset")
            list.add(childBean)
            childBean = EffectsBean(c_name = "淡入/淡出", e_name = "fade", content = "Apply a fade-in and/or fade-out to the audio")
            list.add(childBean)
            childBean = EffectsBean(c_name = "增进/获得", e_name = "gain", content = "Apply gain or attenuation; normalise/equalise/balance/headroom")
            list.add(childBean)
            childBean = EffectsBean(c_name = "响度/音量", e_name = "loudness", content = "Gain control with ISO 226 loudness compensation")
            list.add(childBean)
            childBean = EffectsBean(c_name = "多维度压伸", e_name = "mcompand", content = "Multi-band compression/expansion/limiting")
            list.add(childBean)
            childBean = EffectsBean(c_name = "标准/常态/正常化", e_name = "norm", content = "Normalise to 0dB (or other)")
            list.add(childBean)
            childBean = EffectsBean(c_name = "音频音量", e_name = "vol", content = "Adjust audio volume")
            list.add(childBean)
        }
        "剪辑效果器"->{
            childBean = EffectsBean(c_name = "铺垫", e_name = "pad", content = "Pad (usually) the ends of the audio with silence")
            list.add(childBean)
            childBean = EffectsBean(c_name = "失声", e_name = "silence", content = "Remove portions of silence from the audio")
            list.add(childBean)
            childBean = EffectsBean(c_name = "同步/交叉", e_name = "splice", content = "Perform the equivalent of a cross-faded tape splice")
            list.add(childBean)
            childBean = EffectsBean(c_name = "裁剪", e_name = "trim", content = "Cuts portions out of the audio")
            list.add(childBean)
            childBean = EffectsBean(c_name = "语音端点检测", e_name = "vad", content = "Voice activity detector")
            list.add(childBean)
        }
        "混音效果器"->{
            childBean = EffectsBean(c_name = "多通道", e_name = "channels", content = "Auto mix or duplicate to change number of channels")
            list.add(childBean)
            childBean = EffectsBean(c_name = "分开/分离", e_name = "divide+", content = "Divide sample values by those in the 1st channel (W.I.P.)")
            list.add(childBean)
            childBean = EffectsBean(c_name = "任意混合", e_name = "remix", content = "Produce arbitrarily mixed output channels")
            list.add(childBean)
            childBean = EffectsBean(c_name = "交换立体声通道", e_name = "swap", content = "Swap stereo channels")
            list.add(childBean)
        }
        "节奏和音高效果器"->{
            childBean = EffectsBean(c_name = "弯曲/扭曲", e_name = "bend", content = "Bend pitch at given times without changing tempo")
            list.add(childBean)
            childBean = EffectsBean(c_name = "调整音高", e_name = "pitch", content = "Adjust pitch (= key) without changing tempo")
            list.add(childBean)
            childBean = EffectsBean(c_name = "加速/节奏加快", e_name = "speed", content = "Adjust pitch & tempo together")
            list.add(childBean)
            childBean = EffectsBean(c_name = "延伸/延长", e_name = "stretch", content = "Adjust tempo without changing pitch (simple alg.)")
            list.add(childBean)
            childBean = EffectsBean(c_name = "拍子/节奏", e_name = "tempo", content = "Adjust tempo without changing pitch (WSOLA alg.)")
            list.add(childBean)
        }
        "主线路效果器"->{
            childBean = EffectsBean(c_name = "抖动/颤抖", e_name = "dither", content = "Add dither noise to increase quantisation SNR")
            list.add(childBean)
            childBean = EffectsBean(c_name = "更改采样率", e_name = "rate", content = "Change audio sampling rate")
            list.add(childBean)
        }

        "特殊效果器"->{
            childBean = EffectsBean(c_name = "迪姆/deemph", e_name = "deemph", content = "ISO 908 CD de-emphasis (shelving) IIR filter")
            list.add(childBean)
            childBean = EffectsBean(c_name = "耳机效果", e_name = "earwax", content = "Process CD audio to best effect for headphone use")
            list.add(childBean)
            childBean = EffectsBean(c_name = "除噪/降噪", e_name = "noisered", content = "Filter out noise from the audio")
            list.add(childBean)
            childBean = EffectsBean(c_name = "卡拉ok/ktv", e_name = "oops", content = "Out Of Phase Stereo (or Karaoke) effect")
            list.add(childBean)
            childBean = EffectsBean(c_name = "riaa效果", e_name = "riaa", content = "RIAA vinyl playback equalisation")
            list.add(childBean)
        }

        "其他"->{
            childBean = EffectsBean(c_name = "噪音传感器", e_name = "noiseprof", content = "Produce a DFT profile of the audio (use with noisered)")
            list.add(childBean)
            childBean = EffectsBean(c_name = "光谱图", e_name = "spectrogram", content = "graph signal level vs. frequency & time (needs libpng)")
            list.add(childBean)
            childBean = EffectsBean(c_name = "stat", e_name = "stat", content = "Enumerate audio peak & RMS levels, approx. freq., etc.")
            list.add(childBean)
            childBean = EffectsBean(c_name = "stats", e_name = "stats", content = "Multichannel aware stat")
            list.add(childBean)
            childBean = EffectsBean(c_name = "ladspa/拉德斯帕", e_name = "ladspa", content = "Apply LADSPA plug-in effects e.g. CMT (Computer Music Toolkit)")
            list.add(childBean)
            childBean = EffectsBean(c_name = "合成/调制音频音调或噪声信号", e_name = "synth", content = "Synthesise/modulate audio tones or noise signals")
            list.add(childBean)
            childBean = EffectsBean(c_name = "新文件", e_name = "newfile", content = "Create a new output file when an effects chain ends.")
            list.add(childBean)
            childBean = EffectsBean(c_name = "多链效果重启", e_name = "restart", content = "Restart 1st effects chain when multiple chains exist")
            list.add(childBean)
            childBean = EffectsBean(c_name = "二阶IIR滤波器", e_name = "biquad", content = "2nd-order IIR filter using externally provided coefficients")
            list.add(childBean)
            childBean = EffectsBean(c_name = "丢弃降低采样/压缩", e_name = "downsample", content = "Reduce sample rate by discarding samples")
            list.add(childBean)
            childBean = EffectsBean(c_name = "FFT卷积FIR滤波器", e_name = "fir", content = "FFT convolution FIR filter using externally provided coefficients")
            list.add(childBean)
            childBean = EffectsBean(c_name = "零填充提高采样率", e_name = "upsample", content = "Increase sample rate by zero stuffing")
            list.add(childBean)
        }


    }
    return list;
}

interface SoxService {
    /**
     * 2.2 滤波器类
    sox支持滤波器类音频效果器如下：
    allpass: RBJ all-pass biquad IIR filter
    bandpass: RBJ band-pass biquad IIR filter
    bandreject: RBJ band-reject biquad IIR filter
    band: SPKit resonator band-pass IIR filter
    bass: Tone control: RBJ shelving biquad IIR filter
    equalizer: RBJ peaking equalisation biquad IIR filter
    firfit+: FFT convolution FIR filter using given freq. response (W.I.P.)
    highpass: High-pass filter: Single pole or RBJ biquad IIR
    hilbert: Hilbert transform filter (90 degrees phase shift)
    lowpass: Low-pass filter: single pole or RBJ biquad IIR
    sinc: Sinc-windowed low/high-pass/band-pass/reject FIR
    treble: Tone control: RBJ shelving biquad IIR filter

    2.3 合成效果器
    sox支持合成类音频音效如下：
    chorus: Make a single instrument sound like many
    delay: Delay one or more channels
    echo: Add an echo
    echos: Add a sequence of echos
    flanger: Stereo flanger
    overdrive: Non-linear distortion
    phaser: Phase shifter
    repeat: Loop the audio a number of times
    reverb: Add reverberation
    reverse: Reverse the audio (to search for Satanic messages 😉
    tremolo: Sinusoidal volume modulation

    2.4 音量效果器
    sox支持音量类效果如下：
    compand: Signal level compression/expansion/limiting
    contrast: Phase contrast volume enhancement
    dcshift: Apply or remove DC offset
    fade: Apply a fade-in and/or fade-out to the audio
    gain: Apply gain or attenuation; normalise/equalise/balance/headroom
    loudness: Gain control with ISO 226 loudness compensation
    mcompand: Multi-band compression/expansion/limiting
    norm: Normalise to 0dB (or other)
    vol: Adjust audio volume

    2.5 剪辑效果器
    sox提供音频编辑效果，主要是添加、删除一类的功能，如下：
    pad: Pad (usually) the ends of the audio with silence
    silence: Remove portions of silence from the audio
    splice: Perform the equivalent of a cross-faded tape splice
    trim: Cuts portions out of the audio
    vad: Voice activity detector

    2.6 混音效果器
    sox提供混音类效果器如下：
    channels: Auto mix or duplicate to change number of channels
    divide+: Divide sample values by those in the 1st channel (W.I.P.)
    remix: Produce arbitrarily mixed output channels
    swap: Swap stereo channels

    2.7 节奏和音高效果器
    sox提供节奏和音高修正功能，如下：
    bend: Bend pitch at given times without changing tempo
    pitch: Adjust pitch (= key) without changing tempo
    speed: Adjust pitch & tempo together
    stretch: Adjust tempo without changing pitch (simple alg.)
    tempo: Adjust tempo without changing pitch (WSOLA alg.)

    2.8 主线路效果器
    sox还支持信噪比提升，采样率更改。
    dither: Add dither noise to increase quantisation SNR
    rate: Change audio sampling rate

    2.9 特殊效果器
    sox提供了一些特殊效果器玩法：
    deemph: ISO 908 CD de-emphasis (shelving) IIR filter
    earwax: Process CD audio to best effect for headphone use
    noisered: Filter out noise from the audio
    oops: Out Of Phase Stereo (or Karaoke) effect
    riaa: RIAA vinyl playback equalisation

    2.10 其他
    这里我关注比较多的是sox提供的降噪功能。
    noiseprof: Produce a DFT profile of the audio (use with noisered)
    spectrogram: graph signal level vs. frequency & time (needs libpng)
    stat: Enumerate audio peak & RMS levels, approx. freq., etc.
    stats: Multichannel aware stat

    ladspa: Apply LADSPA plug-in effects e.g. CMT (Computer Music Toolkit)
    synth: Synthesise/modulate audio tones or noise signals
    newfile: Create a new output file when an effects chain ends.
    restart: Restart 1st effects chain when multiple chains exist

    biquad: 2nd-order IIR filter using externally provided coefficients
    downsample: Reduce sample rate by discarding samples
    fir: FFT convolution FIR filter using externally provided coefficients
    upsample: Increase sample rate by zero stuffing
    ————————————————
    版权声明：本文为CSDN博主「愤怒敲代码的小强」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
    原文链接：https://blog.csdn.net/m0_45605854/article/details/120346632
     */
    fun holderEffectsData(): RespondInfo<List<EffectsBean>> {
        println("hashcode " + hashCode() + " , Thread = " + Thread.currentThread() + " SystemTime " + System.currentTimeMillis()/1000)
       return EFFECTS_ARRAY
    }



}